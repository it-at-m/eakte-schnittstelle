package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fabasoft.editions.schemas.gov.createsubfile.CreateSubFileResponseType;
import com.fabasoft.editions.schemas.gov.createsubfile.EGovCoreSubFileType;
import com.fabasoft.schemas.universal.SetResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.RequestContextProvider;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftTransaction;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SubFileRequest;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FabasoftTransactionPropagationTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);
    private static final String OBJECT_ID = "COO.1.2.3";
    private static final SubFileRequest REQUEST = new SubFileRequest(FabasoftObjectType.VORGANG, "parent", "title", "dfv", "subject");

    @Mock
    private FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;

    private FabasoftSubFileService subFileService;
    private FabasoftAttributeService attributeService;

    @BeforeEach
    void setUp() {
        final FabasoftRequestHandler requestHandler = new FabasoftRequestHandler(new RequestContextProvider());
        subFileService = new FabasoftSubFileService(soapClient, requestHandler);
        attributeService = new FabasoftAttributeService(soapClient, requestHandler, new FabasoftAttributeMapperImpl());
    }

    @Nested
    class CreateSubFile {
        @Test
        void givenTransaction_thenPassItsHolderToSoap() {
            final FabasoftTransaction transaction = new FabasoftTransaction();
            when(soapClient.soapCreateSubFile(any(), same(transaction.getHolder()))).thenReturn(createResponse());

            assertEquals(OBJECT_ID, subFileService.createSubFile(CONTEXT, transaction, REQUEST));

            verify(soapClient).soapCreateSubFile(any(), same(transaction.getHolder()));
        }

        @Test
        void givenNoTransaction_thenPassNullToSoap() {
            when(soapClient.soapCreateSubFile(any(), isNull())).thenReturn(createResponse());

            assertEquals(OBJECT_ID, subFileService.createSubFile(CONTEXT, null, REQUEST));

            verify(soapClient).soapCreateSubFile(any(), isNull());
        }
    }

    @Nested
    class SetAttributes {
        @Test
        void givenTransaction_thenPassItsHolderToSoap() {
            final FabasoftTransaction transaction = new FabasoftTransaction();
            when(soapClient.soapGenericSetProperties(any(), same(transaction.getHolder()))).thenReturn(new SetResponseType());

            attributeService.setAttributes(CONTEXT, transaction, OBJECT_ID, List.of());

            verify(soapClient).soapGenericSetProperties(any(), same(transaction.getHolder()));
        }

        @Test
        void givenNoTransaction_thenPassNullToSoap() {
            when(soapClient.soapGenericSetProperties(any(), isNull())).thenReturn(new SetResponseType());

            attributeService.setAttributes(CONTEXT, null, OBJECT_ID, List.of());

            verify(soapClient).soapGenericSetProperties(any(), isNull());
        }
    }

    private static CreateSubFileResponseType createResponse() {
        final EGovCoreSubFileType subFile = new EGovCoreSubFileType();
        subFile.setObjaddress(OBJECT_ID);
        final CreateSubFileResponseType response = new CreateSubFileResponseType();
        response.setSubfile(subFile);
        return response;
    }
}
