package ru.example.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.example.common.messages.Request;
import ru.example.common.messages.Response;
import ru.example.server.processing.ClientDTO;
import ru.example.server.processing.exception.HostNotFoundException;
import ru.example.server.processing.service.ClientService;

import java.util.List;
@RestController
@AllArgsConstructor
@Log
public class HostRestController {

    private ClientService clientService;

    @GetMapping("/hosts")
    public String getHostsInfo() {
        return "{data: \"1 host available\"}";
    }

    @GetMapping("/hosts/{hostId}")
    public String getHostInfo(@PathVariable Long hostId) {
        if (hostId == 1) {
            return "{data: \"Host " + hostId + " ready\"}";
        }else{
            return "{data: \"Host " + hostId + " not ready\"}";
        }
    }

    @GetMapping("/hosts/{hostId}/clients")
    public List<ClientDTO> getClientsInfo(@PathVariable Long hostId) {
        if (hostId != 1) {
            throw new HostNotFoundException();
        }

        return clientService.getAllClients();

    }

    @PostMapping("/hosts/{hostId}/clients/{clientId}")
    public Response getBalance(@PathVariable("hostId") Long hostId,
                               @PathVariable("clientId") Long clientId,
                               @RequestBody Request request) {
        if (hostId != 1) {
            throw new RuntimeException("Host " + hostId + " is not ready!");
        }

        log.info(request.toString());
        Response response = new Response(clientService.getClient(clientId).getAccountDTO().get(0).getBalance());
        log.info(response.toString());
        log.info("balance="+Integer.toString(response.getBalance()));
        return response;
    }
}
