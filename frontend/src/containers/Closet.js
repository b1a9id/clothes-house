import { connect } from 'react-redux';
import Closet from "../components/Closet";
import { startGetItems, startPostItem } from "../actions/Item";
import { startGetBrands } from "../actions/Brand";
import { startGetColors } from "../actions/Color";

const mapStateToProps = (state) => ({
  items: state.Item.items,
  brands: state.Brand.brands,
  colors: state.Color.colors,
  error: state.Item.error
})

const mapDispatchToProps = dispatch => ({
  getItems: () => dispatch(startGetItems()),
  postItem: (request) => dispatch(startPostItem(request)),
  getBrands: () => dispatch(startGetBrands()),
  getColors: () => dispatch(startGetColors()),
})

export default connect(mapStateToProps, mapDispatchToProps)(Closet);
