package socket.interfaces;

import java.util.List;

public interface Interfaces<S, P> {
    public List<S> getAll();
    public S getById(P id);
    public boolean add(S obj);
    public boolean update(S obj);
    public boolean delete(P id);
}
