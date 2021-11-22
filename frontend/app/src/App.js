import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    groups: [],
    selectedOption1: '',
    selectedQuantity1: 0,
  };

  constructor(props) {
    super(props);

    this.handleSelectedOption1Change = this.handleSelectedOption1Change.bind(this);
    this.handleSelectedQuantity1Change = this.handleSelectedQuantity1Change.bind(this);
    this.onSubmitBtnClick = this.onSubmitBtnClick.bind(this);
  }

  async componentDidMount() {
    const response = await fetch('/getSupplierProductsDetails');
    const body = await response.json();
    this.setState({ groups: body, isLoading: false });
  }

  handleSelectedOption1Change(event) {
    this.setState({ selectedOption1: event.target.value });
  }

  handleSelectedQuantity1Change(event) {
    this.setState({ selectedQuantity1: event.target.value });
  }

  async onSubmitBtnClick() {
    const userSelectionObj = {
      username: '',
      email: '',
      product_name_1: this.state.selectedOption1,
      product_quantity_1: this.state.selectedQuantity1,
    };

    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: { userSelectionObj },
    };
    const response = await fetch('/saveOrderDetails', requestOptions);
    const data = await response.json();
  }

  render() {
    const { groups, isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className='App'>
        <header className='App-header'>
          <img src={logo} className='App-logo' alt='logo' />
          <div>Inventory Management System</div>
        </header>
        <div className='App-intro'>
          <h3>IMS Order Form</h3>
          <div className='App-content'>
            <div className='container-fluid'>
              <div className='row'>
                <div className='col-sm'></div>

                <div className='col-sm'>
                  <div className='row'>
                    <div className='col'>
                      <h4>Items</h4>
                      <br />
                      <form>
                        <div className='form-group'>
                          <select id='exampleFormControlSelect' className='Select-style form-control' value={this.state.selectedOption1} onChange={this.handleSelectedOption1Change}>
                            <option key={0}>Select Item</option>
                            {groups.map((group, i) => (
                              <option key={i} value={group.productName}>
                                {group.productName}
                              </option>
                            ))}
                          </select>
                          <br />
                        </div>
                      </form>
                    </div>

                    <div className='col'>
                      <h4>Qty</h4>
                      <br />
                      <input type='number' id='quantityInput' name='quantity' min='1' max='10' onChange={this.handleSelectedQuantity1Change} />
                      <br />
                    </div>
                  </div>

                  <div className='row'>
                    <div className='col'>
                      <form>
                        <div className='form-group'>
                          <select id='exampleFormControlSelect' className='Select-style form-control' value='{this.state.selectValue1}' onChange='{this.handleChange}'>
                            <option key='{0}'>Select Item</option>
                            {groups.map((group, i) => (
                              <option key='{group.productName}' value='{group.productName}'>
                                {group.productName}
                              </option>
                            ))}
                          </select>
                          <br />
                        </div>
                      </form>
                    </div>

                    <div className='col'>
                      <input type='number' id='quantityInput' name='quantity' min='1' max='10' />
                      <br />
                    </div>
                  </div>

                  <div className='row'>
                    <div className='col'>
                      <form>
                        <div className='form-group'>
                          <select id='exampleFormControlSelect' className='Select-style form-control' value='{this.state.selectValue1}' onChange='{this.handleChange}'>
                            <option key='{0}'>Select Item</option>
                            {groups.map((group, i) => (
                              <option key='{group.productName}' value='{group.productName}'>
                                {group.productName}
                              </option>
                            ))}
                          </select>
                          <br />
                        </div>
                      </form>
                    </div>

                    <div className='col'>
                      <input type='number' id='quantityInput' name='quantity' min='1' max='10' />
                      <br />
                    </div>
                  </div>

                  <div className='row'>
                    <div className='col'>
                      <form>
                        <div className='form-group'>
                          <select id='exampleFormControlSelect' className='Select-style form-control' value='{this.state.selectValue1}' onChange='{this.handleChange}'>
                            <option key='{0}'>Select Item</option>
                            {groups.map((group, i) => (
                              <option key='{group.productName}' value='{group.productName}'>
                                {group.productName}
                              </option>
                            ))}
                          </select>
                          <br />
                        </div>
                      </form>
                    </div>

                    <div className='col'>
                      <input type='number' id='quantityInput' name='quantity' min='1' max='10' />
                      <br />
                    </div>
                  </div>

                  <div className='row'>
                    <div className='col'>
                      <form>
                        <div className='form-group'>
                          <select id='exampleFormControlSelect' className='Select-style form-control' value='{this.state.selectValue1}' onChange='{this.handleChange}'>
                            <option key='{0}'>Select Item</option>
                            {groups.map((group, i) => (
                              <option key='{group.productName}' value='{group.productName}'>
                                {group.productName}
                              </option>
                            ))}
                          </select>
                          <br />
                        </div>
                      </form>
                    </div>

                    <div className='col'>
                      <input type='number' id='quantityInput' name='quantity' min='1' max='10' />
                      <br />
                    </div>
                  </div>

                  <button type='button' className='btn btn-dark' onClick={this.onSubmitBtnClick}>
                    Submit
                  </button>
                </div>

                <div className='col-sm'></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default App;

/* <div key={groups.emailId}>{groups.emailId}</div>
<div key={groups.city}>{groups.city}</div>
<div key={groups.state}>{groups.state}</div>
<div key={groups.country}>{groups.country}</div> */
