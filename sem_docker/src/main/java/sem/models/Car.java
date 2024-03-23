package sem.models;

public class Car {
    private Integer _id;
    private String _make;
    private String _model;

    public Car(Integer _id, String _make, String _model){
        this._id = _id;
        this._make = _make;
        this._model = _model;
    }

    public void setId(Integer id){
        _id = id;
    }

    public void setMake(String make){
        _make = make;
    }

    public void setModel(String model){
        _model = model;
    }

    public Integer getId(){
        return _id;
    }

    public String getMake(){
        return _make;
    }

    public String getModel(){
        return _model;
    }
}
