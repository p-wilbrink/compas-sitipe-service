package org.lfenergy.compas.sitipe.data.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.lfenergy.compas.sitipe.data.entity.BayTypical;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class BayTypicalRepository implements PanacheRepository<BayTypical> {

    public List<BayTypical> findByAccessId(final String accessId) {
        return this.list("accessId", accessId);
    }




}
