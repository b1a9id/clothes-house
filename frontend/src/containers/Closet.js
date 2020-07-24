import { connect } from 'react-redux';
import Closet from "../components/Closet";
import { startRequest as itemsStartRequest } from "../actions/Item";
import { startRequest as brandsStartRequest } from "../actions/Brand";

const mapStateToProps = (state) => ({
  items: state.Item.items,
  brands: state.Brand.brands,
  error: state.Item.error
})

const mapDispatchToProps = dispatch => ({
  getItems: () => dispatch(itemsStartRequest()),
  getBrands: () => dispatch(brandsStartRequest())
})

export default connect(mapStateToProps, mapDispatchToProps)(Closet);
