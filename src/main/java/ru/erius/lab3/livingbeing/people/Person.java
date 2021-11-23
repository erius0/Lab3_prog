package ru.erius.lab3.livingbeing.people;

import ru.erius.lab3.livingbeing.LivingBeing;

import java.util.Objects;

public class Person extends LivingBeing {

    protected String speech;

    public Person(String name) {
        this(name, 0, null);
    }

    public Person(LivingBeing livingBeing) {
        this(livingBeing.getName(), livingBeing.getAge());
    }

    public Person(String name, int age) {
        this(name, age, null);
    }

    public Person(String name, int age, String speech) {
        super(name, age);
        this.speech = speech;
    }

    @Override
    public void speak() {
        if (speech == null) throw new PersonSpeechException("Попытка вызова метода speak() у человека " + this.name + " без реплики");
        if (speech.isEmpty()) throw new PersonSpeechException("Попытка вызова метода speak() у человека " + this.name + " с пустой репликой");
        System.out.println(this.name + " говорит: '" + this.speech + "'");
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public static class PersonSpeechException extends RuntimeException {
        public PersonSpeechException() {

        }

        public PersonSpeechException(String message) {
            super(message);
        }

        public PersonSpeechException(String message, Throwable cause) {
            super(message, cause);
        }

        public PersonSpeechException(Throwable cause) {
            super(cause);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(speech, person.speech);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speech);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", speech='" + speech + '\'' +
                '}';
    }
}
