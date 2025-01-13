package io.github.yorucyber.inventory_api.services;

import io.github.yorucyber.inventory_api.dto.ProviderDTO;
import io.github.yorucyber.inventory_api.entities.Provider;
import io.github.yorucyber.inventory_api.exceptions.SaleNotFoundException;
import io.github.yorucyber.inventory_api.repositories.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private IProviderRepository providerRepository;


    @Transactional
    public List<ProviderDTO> findAll() {
        List<Provider> providers = providerRepository.findAll();
        return providers.stream().map(ProviderDTO::toDTO).toList();
    }

    @Transactional
    public ProviderDTO save(ProviderDTO providerDTO) {

        Provider provider = ProviderDTO.toEntity(providerDTO);

        Provider savedProvider = providerRepository.save(provider);
        // Save the sale
        return ProviderDTO.toDTO(savedProvider);
    }

    public ProviderDTO findById(long id) {
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new SaleNotFoundException("Sale not found with id: " + id, id));
        return ProviderDTO.toDTO(provider);
    }

    @Transactional
    public ProviderDTO update(long id, ProviderDTO updatedProviderDTO) {
        // Fetch the associated medicine
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new SaleNotFoundException("Sale not found with id: " + id, id));
        Provider updatedProvider = ProviderDTO.toEntity(updatedProviderDTO);
        updatedProvider.setId(id);
        Provider savedSale = providerRepository.save(updatedProvider);
        return ProviderDTO.toDTO(savedSale);
    }

    @Transactional
    public void deleteById(long id) {
        providerRepository.deleteById(id);
    }
}
