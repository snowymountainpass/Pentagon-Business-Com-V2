

const Checkbox = ({ label, isSelected, onCheckboxChange }) => (
    <div className="form-check">
        <label className="custom-control custom-checkbox">
            <input
                type="checkbox"
                name={label}
                checked={isSelected}
                onChange={onCheckboxChange}
                className="custom-control-input"
            />
            {label}
        </label>
    </div>
);

export default Checkbox;