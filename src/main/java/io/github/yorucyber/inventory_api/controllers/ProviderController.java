package io.github.yorucyber.inventory_api.controllers;

import io.github.yorucyber.inventory_api.dto.ProviderDTO;
import io.github.yorucyber.inventory_api.services.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {
    private final ProviderService providerService;
    Logger logger = LoggerFactory.getLogger(SaleController.class);

    ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/")
    public List<ProviderDTO> all() {
        return providerService.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/")
    public ProviderDTO create(@RequestBody ProviderDTO providerDTO) {
        return providerService.save(providerDTO);
    }

    // Returns a single item
    //Needs error handle when entity doesn't exist
    @GetMapping("/{id}")
    public ProviderDTO find(@PathVariable Long id) {
        try {
            return providerService.findById(id);
        } catch (Exception e) {
            logger.error("Error retrieving medicine", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found", e);
        }

    }

    @PutMapping("/{id}")
    public ProviderDTO update(@RequestBody ProviderDTO providerDTO, @PathVariable Long id) {
        try {
            return providerService.update(id, providerDTO);
        } catch (Exception e) {
            logger.error("Error retrieving sale", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        providerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
