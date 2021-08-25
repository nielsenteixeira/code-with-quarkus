package org.nielsen;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@QuarkusTest
@DBRider
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProductIT {

    @Test
    @DataSet(value = "products.yml")
    @DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE, schema = "public")
    public void test() {
        Assertions.assertEquals(1, Product.count());
    }
}
