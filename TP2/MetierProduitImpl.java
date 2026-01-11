import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<ProductFull> {
    private final List<ProductFull> products = new ArrayList<>();

    @Override
    public void add(ProductFull o) {
        products.add(o);
    }

    @Override
    public List<ProductFull> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public ProductFull findById(long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(long id) {
        return products.removeIf(p -> p.getId() == id);
    }
}