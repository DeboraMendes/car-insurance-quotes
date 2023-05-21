package br.com.audsat.carinsurancequotes.controllers;

import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationRequestDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceQueryResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Insurance Budget", description = "Insurance Budget APIs")
public interface InsuranceBudgetController {

    @Operation(
            summary = "Cadastro de orçamento",
            description = """
                    O orçamento do seguro é calculado com base em algumas premissas, estas premissas serão listadas a seguir:
                    1. O valor base de cálculo do orçamento é de 6% com base no valor da tabela fipe do veículo.
                    2. Quanto maior o risco maior será o valor do seguro e para cada item de risco mapeado 2% a mais será acrescentado na base de cálculo.
                    São estes os riscos mapeados:
                        * O motorista principal se encontra na faixa etária de 18 a 25 anos.
                        * O motorista possui sinistro em seu nome.
                        * O veículo segurado possui sinistro."""
    )
    ResponseEntity<InsuranceCreationResponseDTO> createInsurance(final InsuranceCreationRequestDTO insuranceCreationRequestDTO);

    @Operation(
            summary = "Consulta de orçamento",
            description = "Consulta o orçamento pelo id."
    )
    ResponseEntity<InsuranceQueryResponseDTO> findInsuranceById(@Parameter(description = "Identificação do orçamento.", example = "1") final Long id);

    @Operation(
            summary = "Atualização de orçamento",
            description = "Atualiza o status do orçamento pelo id."
    )
    void updateInsuranceStatusById(@Parameter(description = "Identificação do orçamento.", example = "1") final Long id,
                                   @Parameter(description = "Flag para indicar se o orçamento está ativo.", example = "false") final Boolean active);

    @Operation(
            summary = "Remoção de orçamento",
            description = "Remove o orçamento pelo id."
    )
    void deleteInsuranceById(@Parameter(description = "Identificação do orçamento.", example = "1") final Long id);
}
