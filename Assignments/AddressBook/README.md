## Getting Started

Write a program that functions as an address book. It should have entries containing at least the following information: first and last name, phone number, address, and email address. You should be able to add entries and remove entries, as well as printing out any given entry. It should save entries to a file, and be able to read in entries from a file as well.

The address book must be able to sort by at least one field (preferably last name). You may use any sort for this that you like.

## Outline

1. Load from file - Done
2. Save to file - Done
3. Add an entry - Done
4. Remove an entry - Done
5. Edit an existing entry - Done
6. Sort the address book - Done
7. Search for a specific entry - Done
8. Quit - Done

## How to go about coding this

- Each time the program starts read from the file and store it in an arraylist
- Use filereader and filewriter classes
- Use arraylist to store the entries as a list and also it can be used to easily sort the entries
- Write the only edits to the file, not the whole arraylist
- For searching, use either the full keyword or the beginning of the keyword in any of the fields

## Grading

- An excellent program will be able to sort the entries by any field (first name, last name, phone number, email address, etc).
- An excellent program will be able to display only entries matching a certain criteria (only last names beginning with the letter 'M', for example).
- An excellent program easily and intelligently handles the use of multiple address books (multiple files).