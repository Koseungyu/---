package com.springbasic.kyh_springbasic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("koeul");
        helloLombok.setAge(31);
        System.out.println("helloLombok의 이름 = " + helloLombok.getName());
        System.out.println("helloLombok의 나이 = " + helloLombok.getAge());
        System.out.println("helloLombok = " + helloLombok);
    }
}
