package AarogyaHospital;

public interface DaoInterface1 {
		public void supplierRegistration(Supplierdetails s);
		public void viewAllSupplier();
		public void searchBySupplierId();
		public void deleteBySupplierId();
		public void medicineRegistration(MedicineDetails s1);
		public void viewAllMedicine();
		public void searchByMedicineId();
		public void deleteByMedicineId();
	}
