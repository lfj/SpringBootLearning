package com.lfj.demo.service.impl;

import com.lfj.demo.service.ICountryService;

import java.util.ArrayList;
import java.util.List;

public class OperateCountryTask implements Runnable {

    private List<ICountryService> countryServiceList = new ArrayList<>();

    public List<ICountryService> getCountryServiceList() {
        return countryServiceList;
    }

    public void setCountryServiceList(List<ICountryService> countryServiceList) {
        this.countryServiceList = countryServiceList;
    }

    @Override
    public void run() {
        for (ICountryService iCountryService : countryServiceList) {
            iCountryService.isDevelopedCountry();
        }
    }
}
