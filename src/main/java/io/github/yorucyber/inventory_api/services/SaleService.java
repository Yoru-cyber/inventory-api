package io.github.yorucyber.inventory_api.services;

import io.github.yorucyber.inventory_api.dto.SaleDTO;
import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.entities.Provider;
import io.github.yorucyber.inventory_api.entities.Sale;
import io.github.yorucyber.inventory_api.exceptions.MedicineNotFoundException;
import io.github.yorucyber.inventory_api.exceptions.SaleNotFoundException;
import io.github.yorucyber.inventory_api.repositories.IMedicineRepository;
import io.github.yorucyber.inventory_api.repositories.IProviderRepository;
import io.github.yorucyber.inventory_api.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private IMedicineRepository medicineRepository;
    @Autowired
    private IProviderRepository providerRepository;

    @Transactional
    public List<SaleDTO> findAll() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream().map(SaleDTO::toDTO).toList();
    }

    @Transactional
    public SaleDTO save(SaleDTO saleDTO) {
        // Fetch the associated medicine
        Provider provider = providerRepository.findById(saleDTO.providerId()).orElseThrow(() -> new MedicineNotFoundException("Medicine not found", saleDTO.providerId()));
        Medicine medicine = medicineRepository.findById(saleDTO.medicineId()).orElseThrow(() -> new MedicineNotFoundException("Medicine not found", saleDTO.medicineId()));
        Sale sale = SaleDTO.toEntity(saleDTO, medicine, provider);
        // Update the stock
        // Medicine stock cannot be a negative number. Example -200
        medicine.setStock(medicine.getStock() - sale.getStock());

        Sale savedSale = saleRepository.save(sale);
        // Save the sale
        return SaleDTO.toDTO(savedSale);
    }

    public SaleDTO findById(long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new SaleNotFoundException("Sale not found with id: " + id, id));
        return SaleDTO.toDTO(sale);
    }

    @Transactional
    public SaleDTO update(long id, SaleDTO updatedSaleDTO) {
        // Fetch the associated medicine
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new SaleNotFoundException("Sale not found with id: " + id, id));
        Provider provider = Provider.builder().name("Pharmacorp").build();
        Medicine medicine = medicineRepository.findById(updatedSaleDTO.medicineId()).orElseThrow(() -> new MedicineNotFoundException("Medicine not found", updatedSaleDTO.medicineId()));
        Sale updatedSale = SaleDTO.toEntity(updatedSaleDTO, medicine, provider);
        updatedSale.setId(id);
        Sale savedSale = saleRepository.save(updatedSale);
        return SaleDTO.toDTO(savedSale);
    }

    @Transactional
    public void deleteById(long id) {
        saleRepository.deleteById(id);
    }

}
