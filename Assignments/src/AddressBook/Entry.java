package AddressBook;

import java.util.Comparator;

class Entry implements Comparable<Entry> {
    // Initializing all the variables needed to store the details
    private String first;
    private String last;
    private String address;
    private String phone;
    private String email;

    // Constructor which declares all the variables
    Entry(String first, String last, String address, String phone, String email) {
        this.first = first;
        this.last = last;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Natural order sorting by the first name
     * 
     * @return the ArrayList of the entries sorted by the first name
     */
    @Override
    public int compareTo(Entry o) {
        return this.first.compareToIgnoreCase(o.first);
    }

    public static class sortByLast implements Comparator<Entry> {
        /**
         * @return the ArrayList sorted by last name
         */
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.last.compareToIgnoreCase(o2.last);
        }

    }

    public static class sortByAddress implements Comparator<Entry> {
        /**
         * @return the ArrayList sorted by the address
         */
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.address.compareToIgnoreCase(o2.address);
        }

    }

    public static class sortByPhone implements Comparator<Entry> {
        /**
         * @return the ArrayList soretd by the phone number
         */
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.phone.compareTo(o2.phone);
        }

    }

    public static class sortByEmail implements Comparator<Entry> {
        /**
         * @return the ArrayList soretd by the email id
         */
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.email.compareTo(o2.email);
        }

    }

    // Getter methods for all the fields
    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Setter method for all the fields
    public void set(String first, String last, String address, String phone, String email) {
        this.first = first;
        this.last = last;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
