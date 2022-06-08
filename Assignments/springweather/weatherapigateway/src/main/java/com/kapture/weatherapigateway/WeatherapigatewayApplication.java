package com.kapture.weatherapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="springweather", path = "api/v2", contextId = "v2")
interface WeatherServerClientV2 {
	@RequestMapping(method = RequestMethod.GET, value = "weather", consumes = "application/json")
	OpenWeatherApiResponse getWeatherByCity(@RequestParam("cityStateCountry") String cityStateCountry);

	@RequestMapping(method = RequestMethod.GET, value = "weather", consumes = "application/json")
	OpenWeatherApiResponse getWeatherByZip(@RequestParam("zip") String zip);
}

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WeatherapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherapigatewayApplication.class, args);
	}

	@RestController("gateway-api")
	@RequestMapping()
	public class WeatherGatewayService {

		private final WeatherServerClientV2 weatherClientV2;

		public WeatherGatewayService(WeatherServerClientV2 weatherClientV2) {
			this.weatherClientV2 = weatherClientV2;
		}

		@GetMapping("/temperature/city/{cityStateCountry}")
		String getTempByCity(@PathVariable("cityStateCountry") String cityStateCountry) {
			OpenWeatherApiResponse weatherApiResponse = weatherClientV2.getWeatherByCity(cityStateCountry);
			return weatherApiResponse.getMain().getTemp().toString()+"°C, feels like "
					+ weatherApiResponse.getMain().getFeels_like().toString()+"°C with "
					+ weatherApiResponse.getWeather().get(0).getDescription();
		}

		@GetMapping("/temperature/zip/{zip}")
		String getTempByZip(@PathVariable("zip") String zip) {
			OpenWeatherApiResponse weatherApiResponse = weatherClientV2.getWeatherByZip(zip);
			return weatherApiResponse.getMain().getTemp().toString()+"°C, feels like "
					+ weatherApiResponse.getMain().getFeels_like().toString()+"°C with "
					+ weatherApiResponse.getWeather().get(0).getDescription();
		}
	}

}