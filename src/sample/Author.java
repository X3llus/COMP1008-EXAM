package sample;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Author {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Author(String firstName, String lastName, LocalDate birthday) throws IllegalAccessException {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalAccessException {
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        if (checkName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalAccessException("First name must be more than one character and cannot include numbers or special characters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalAccessException {
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        if (checkName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalAccessException("Last name must be more than one character and cannot include numbers or special characters");
        }
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) throws IllegalAccessException {
        if (birthday.isBefore(LocalDate.now().minusYears(3))) {
            this.birthday = birthday;
        } else {
            throw new IllegalAccessException("Date must be more than 3 years ago");
        }
    }

    public int getAge() {
        return LocalDate.now().minusYears(birthday.getYear()).getYear();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " aged: " + getAge();
    }

    private boolean checkName(String input) {
        String regex = "^[a-zA-Z]{2,}([ ]+[a-zA-Z]{2,})*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }
}
