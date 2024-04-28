package core.basesyntax.service.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private OperationStrategy operationStrategy;

    public StorageServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<FruitTransaction> transactions) {
        if (transactions.equals(null)) {
            throw new RuntimeException("Value cannot be null");
        }
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.process(transaction);
        }
    }
}