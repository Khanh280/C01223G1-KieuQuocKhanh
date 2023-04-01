package case_study_furama.repository.impl_repository;

import case_study_furama.models.Contract;
import case_study_furama.repository.IContractsRepository;
import case_study_furama.utils.ReadAndWriteDataContracts;

import java.util.ArrayList;
import java.util.List;

public class ContrcatsRepositoryImpl implements IContractsRepository {
    List<Contract> contractList = new ArrayList<>();

    @Override
    public void createNewContractRepository(List<Contract> contractLis) {
        ReadAndWriteDataContracts.writeListToFile(contractLis, false);
    }

    @Override
    public List<Contract> displayListContractRepository() {
        contractList = ReadAndWriteDataContracts.readFileToList();
        return contractList;
    }

    @Override
    public void editContractRepository(List<Contract> contractLis) {
        ReadAndWriteDataContracts.writeListToFile(contractList, false);
    }
}
