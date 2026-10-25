package com.pm.patient_service.dto;

import com.pm.patient_service.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {

    @NotBlank
    @Size(max = 100, message = "name must be less than 100 characters")
    private String name;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotNull(message = "Date of birth cannot be blank")
    private String dateOfBirth;

    @NotNull(groups = CreatePatientValidationGroup.class ,message = "Registered date cannot be blank")
    private String registeredDate;

    public @NotBlank @Size(max = 100, message = "name must be less than 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 100, message = "name must be less than 100 characters") String name) {
        this.name = name;
    }

    public @NotBlank @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Address cannot be blank") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address cannot be blank") String address) {
        this.address = address;
    }

    public @NotNull(message = "Date of birth cannot be blank") String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "Date of birth cannot be blank") String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
