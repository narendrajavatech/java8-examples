package io.shekhar.trainings.java8.api_design;

/**
 * Created by shekhargulati on 20/09/15.
 */
            public class App3 implements E, F {
                @Override
                public void doSth() {
                    F.super.doSth();
                }
                public static void main(String[] args) {
                    new App3().doSth();
                }
            }

            interface E {
                default void doSth() {
                    System.out.println("inside E");
                }
            }

            interface F {
                default void doSth() {
                    System.out.println("inside F");
                }
            }