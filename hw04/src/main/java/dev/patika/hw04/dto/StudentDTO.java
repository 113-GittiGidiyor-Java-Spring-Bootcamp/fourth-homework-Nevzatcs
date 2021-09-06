package dev.patika.hw04.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @ApiModelProperty(hidden = true)
    private int id;

    @ApiModelProperty(example = "Koray Güney")
    @NotBlank(message = "Name is mandatory")
    private String s_name;

    @ApiModelProperty(example = "22/05/2000")
    @NotBlank(message = "Birth date is mandatory")
    private LocalDate s_birthDate;

    @ApiModelProperty(example = "5")
    @NotBlank(message = "Address is mandatory")
    private String s_address;

    @ApiModelProperty(example = "5")
    @NotBlank(message = "Gender is mandatory")
    private String s_gender;
}
