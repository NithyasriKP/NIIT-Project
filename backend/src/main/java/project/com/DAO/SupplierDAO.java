package project.com.DAO;

import java.util.List;
import java.util.function.Supplier;



public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> listSuppliers();
	public Supplier getSupplier(int supplierId);

}
