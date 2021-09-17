package dev.patika.hw04.dto;

import dev.patika.hw04.model.AbstractBaseEntity;
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
public class StudentDTO extends AbstractBaseEntity {
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Koray Güney")
    @NotBlank(message = "Name is mandatory")
    private String s_name;

    @ApiModelProperty(example = "2000-05-05")
    @NotBlank(message = "Birth date is mandatory")
    private LocalDate s_birthDate;

    @ApiModelProperty(example = "Ankara")
    @NotBlank(message = "Address is mandatory")
    private String s_address;

    @ApiModelProperty(example = "Male")
    @NotBlank(message = "Gender is mandatory")
    private String s_gender;
}
