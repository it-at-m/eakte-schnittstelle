package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.TXContext;
import jakarta.xml.ws.Holder;
import lombok.Getter;

@Getter
public class FabasoftTransaction {
    private final Holder<TXContext> holder;

    public FabasoftTransaction() {
        final TXContext txContext = new TXContext();
        txContext.setCommit(false);
        this.holder = new Holder<>(txContext);
    }
}
