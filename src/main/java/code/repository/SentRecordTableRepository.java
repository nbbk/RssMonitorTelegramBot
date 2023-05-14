package code.repository;

import code.config.Config;
import code.eneity.SentRecordTableEntity;
import code.repository.mapper.TableRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SentRecordTableRepository extends TableRepository<SentRecordTableEntity> {

    public SentRecordTableRepository() {
        super(Config.DBPath);
    }

    public void save(SentRecordTableEntity entity) {
        SentRecordTableEntity where = new SentRecordTableEntity();
        where.setId(entity.getId());
        Integer count = super.selectCount(where);
        if (count == 0) {
            super.insert(entity);
        }
    }

    public Boolean exists(String name, String chatId) {
        return exists(null, name, chatId);
    }
    public Boolean exists(String id, String name, String chatId) {
        SentRecordTableEntity where = new SentRecordTableEntity();
        where.setId(id);
        where.setName(name);
        where.setChatId(chatId);
        Integer count = super.selectCount(where);
        if (null == count) {
            return null;
        }
        return count > 0;
    }

}
