package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import static de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftTestFixtures.OBJECT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftTestFixtures.REQUEST_CONTEXT;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fabasoft.schemas.universal.SetResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.RequestContextProvider;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftTransaction;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FabasoftAttributeServiceTest {
    @Mock
    private FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;

    private FabasoftAttributeService service;

    @BeforeEach
    void setUp() {
        service = new FabasoftAttributeService(soapClient, new FabasoftRequestHandler(new RequestContextProvider()),
                new FabasoftAttributeMapperImpl());
    }

    @Test
    void givenTransaction_thenPassItsHolderToSoap() {
        final FabasoftTransaction transaction = new FabasoftTransaction();
        when(soapClient.soapGenericSetProperties(any(), same(transaction.getHolder()))).thenReturn(new SetResponseType());

        service.setAttributes(REQUEST_CONTEXT, transaction, OBJECT_ID, List.of());

        verify(soapClient).soapGenericSetProperties(any(), same(transaction.getHolder()));
    }

    @Test
    void givenNoTransaction_thenPassNullToSoap() {
        when(soapClient.soapGenericSetProperties(any(), isNull())).thenReturn(new SetResponseType());

        service.setAttributes(REQUEST_CONTEXT, null, OBJECT_ID, List.of());

        verify(soapClient).soapGenericSetProperties(any(), isNull());
    }
}
