package dev.patika.hw04.dto;

import dev.patika.hw04.model.AbstractBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO extends AbstractBaseEntity {
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Koray Can")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @ApiModelProperty(example = "Istanbul")
    @NotBlank(message = "Address is mandatory")
    private String address;

    @ApiModelProperty(example = "5364786524")
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

}
