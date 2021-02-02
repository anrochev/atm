package ru.example.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.example.dto.BalanceDTO;

@Service
public class ATMService {

    public BalanceDTO getClientBalance(Long clientId, Long accountId, int PIN, String balanceStr) {
        int bal1;
        BalanceDTO bal2;
        Gson gson = new Gson();
        bal2=gson.fromJson(balanceStr,BalanceDTO.class);
        return new BalanceDTO(bal2.getBalance());
    }
}
