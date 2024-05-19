package com.syshco.referral.service;

import com.syshco.referral.exception.NotFoundException;
import com.syshco.referral.entity.Company;
import com.syshco.referral.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(UUID id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Company not found with id:" + id));
    }

    @Transactional
    public Company createCompany(Company company) {
        company.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        company.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return companyRepository.save(company);
    }

    @Transactional
    public Company updateCompany(UUID id, Company updatedCompany) {
        Company existingCompany = getCompanyById(id);

        existingCompany.setName(updatedCompany.getName());
        existingCompany.setAddress(updatedCompany.getAddress());
        existingCompany.setWebsite(updatedCompany.getWebsite());
        existingCompany.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return companyRepository.save(existingCompany);
    }

    public void deleteCompany(UUID id) {
        companyRepository.deleteById(id);
    }
}
