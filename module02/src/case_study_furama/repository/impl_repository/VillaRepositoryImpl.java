package case_study_furama.repository.impl_repository;

import case_study_furama.models.facility.Villa;
import case_study_furama.repository.IVillaRepository;
import case_study_furama.utils.ReadAndWriteDataVilla;

import java.util.ArrayList;
import java.util.List;

public class VillaRepositoryImpl implements IVillaRepository {
    List<Villa> villas = new ArrayList<>();

    @Override
    public void addVilla(List<Villa> villas) {
        ReadAndWriteDataVilla.writeVillaToFile(villas, false);
    }

    @Override
    public void editVillaList() {

    }

    @Override
    public void deleteVilla() {

    }

    @Override
    public List<Villa> displayVillaList() {
        villas = ReadAndWriteDataVilla.readFileToList();
        return villas;
    }
}
