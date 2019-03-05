package com.example.demo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Id;


@Setter
@Getter

@Component
public class Scure1 {
    @Id
    @Column(name = "var1", nullable = false)
    String v1 = "testing";
    @Column(name = "var2")
    String v2 = "dodge";

    @Column(name = "num1")
    int num1 = 1234;
    @Column(name = "num2")
    int num2 = 5678;

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }
}
