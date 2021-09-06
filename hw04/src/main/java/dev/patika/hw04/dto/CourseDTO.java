package dev.patika.hw04.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    @ApiModelProperty(hidden = true)
    private int id;

    @ApiModelProperty(example = "Koray")
    @NotBlank(message = "First Name is mandatory")
    private String courseName;

    @ApiModelProperty(example = "5")
    @NotBlank(message = "Course code is mandatory")
    private int courseCode;

    @ApiModelProperty(example = "5")
    @NotNull(message = "Credit score is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int creditScore;


}
