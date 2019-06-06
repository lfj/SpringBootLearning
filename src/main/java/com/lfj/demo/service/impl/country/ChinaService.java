package com.lfj.demo.service.impl.country;

import com.lfj.demo.service.ICountryService;
import org.springframework.stereotype.Service;

@Service
public class ChinaService implements ICountryService {

    @Override
    public boolean isDevelopedCountry() {
        System.out.println("It is a pity!Our country is not a developed country yet!");
        return false;
    }
}
