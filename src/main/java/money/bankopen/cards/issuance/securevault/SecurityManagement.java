package money.bankopen.cards.issuance.securevault;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import money.bankopen.cards.issuance.securevault.generateCVV.GenerateCVV;
import money.bankopen.cards.issuance.securevault.issuarkey.IssuerKey;
import money.bankopen.cards.issuance.securevault.networkkey.NetworkKeyResponse;
import money.bankopen.cards.issuance.securevault.storecard.StoreCard;
import money.bankopen.cards.issuance.securevault.storecard.StoreCardDTO;
import money.bankopen.cards.issuance.securevault.storecard.StoreCardResponse;
import money.bankopen.cards.issuance.securevault.generateCVV.GenerateCVVResponse;
import money.bankopen.cards.issuance.securevault.issuarkey.IssuerKeyResponse;
import money.bankopen.cards.issuance.securevault.networkkey.NetworkKey;
import money.bankopen.cards.issuance.securevault.storecard.StoreCardService;
import money.bankopen.cards.issuance.securevault.utils.CardNumberGenerator;
import money.bankopen.cards.issuance.securevault.utils.IssuanceResponse;
import money.bankopen.cards.issuance.securevault.utils.ResponseCodes;
import money.bankopen.cards.issuance.securevault.verifycvv.VerifyCVV;
import money.bankopen.cards.issuance.securevault.verifycvv.VerifyCVVResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/Security")
public class SecurityManagement {

    @Autowired
    StoreCardService storeCardService;

    @Operation(summary = "IssuerKey")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "IssuerKey Response",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = IssuerKeyResponse.class)) }) })
    @RequestMapping(path = "/issuerKey/{id}", method = RequestMethod.GET)
    public IssuerKey issuerKey(@Valid  @PathVariable @Schema(example = "#ISSUERKEYID",title = "Unique Issuer key Id",required = true) String id , @RequestBody IssuerKey issuerKey) {
        return issuerKey;
    }

    @Operation(summary = "NetworkKey")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "NetworkKey Response",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NetworkKeyResponse.class)) }) })
    @RequestMapping(path = "/networkKey/{id}", method = RequestMethod.GET)
    public NetworkKey networkKey(@Valid  @Schema(example = "#NETWORKKEYID",title = "Unique Issuer key Id",required = true) @PathVariable String id , @RequestBody NetworkKey networkKey) {
        return networkKey;
    }

    @Operation(summary = "GenerateCVV")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "GenerateCVV Response",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenerateCVVResponse.class)) }) })
    @RequestMapping(path = "/generateCVV", method = RequestMethod.POST)
    public GenerateCVV generateCVV(@Valid  @RequestBody GenerateCVV generateCVV) {
        return generateCVV;
    }

    @Operation(summary = "VerifyCVV")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "NetworkKey Response",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VerifyCVVResponse.class)) }) })
    @RequestMapping(path = "/verifyCVV", method = RequestMethod.POST)
    public VerifyCVV verifyCVV(@Valid  @RequestBody VerifyCVV verifyCVV) {
        return verifyCVV;
    }

    @Operation(summary = "StoreCard")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "StoreCard Response",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StoreCardResponse.class)) }) })
    @RequestMapping(path = "/storeCard", method = RequestMethod.POST)
    public ResponseEntity<IssuanceResponse> storeCard(@Valid  @RequestBody StoreCard storeCard) throws NoSuchAlgorithmException {

        IssuanceResponse response = new IssuanceResponse();

        StoreCardDTO storeCardDTO = new StoreCardDTO();
        storeCardDTO.setId(CardNumberGenerator.genHash(storeCard.getServiceData().getCardNumber()));
        storeCardDTO.setEncrCard(CardNumberGenerator.encrypt("1234",storeCard.getServiceData().getCardNumber()));
        String result =null;
        try {
            result = storeCardService.storeCard(storeCardDTO);
        }catch(Exception e)
        {

        }
        if(result==null)
        {
            response.setResponseCode(ResponseCodes.CONFIG_ERROR.getCode());
            response.setException("StoreCard Push error...[result]");
            return new ResponseEntity<IssuanceResponse>(response, HttpStatus.BAD_REQUEST);
        }

        System.out.println("result:"+result);
        response.setResponseCode(ResponseCodes.SUCCESS.getCode());
        response.setException(null);
        response.setResult(result);
        return new ResponseEntity<IssuanceResponse>(response, HttpStatus.OK);
    }


}
