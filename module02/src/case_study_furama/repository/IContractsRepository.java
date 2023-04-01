package case_study_furama.repository;

import case_study_furama.models.Contract;

import java.util.List;

public interface IContractsRepository {
    void createNewContractRepository(List<Contract> contractList);

    List<Contract> displayListContractRepository();

    void editContractRepository(List<Contract> contractList);
}
