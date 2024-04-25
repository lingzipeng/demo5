package com.example.demo.student.vo;

import lombok.Data;

import java.util.List;


@Data
public class BarEchartsSeriesModel {
    private List<Double> data;
    private String type;
    private String name;
}
