

const Checkbox = ({ label, isSelected, onCheckboxChange }) => (

    <label className="custom-control custom-checkbox">
        <input
            type="checkbox"
            name={label}
            checked={isSelected}
            onChange={onCheckboxChange}
            className="custom-control-input"
        />
        <div className="custom-control-label">
            {label} <b className="badge badge-pill badge-light float-right">120</b>
        </div>

    </label>

);

export default Checkbox;