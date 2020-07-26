import { connect } from 'react-redux';
import Closet from "../components/Closet";
import { startGetItems, startPostItem } from "../actions/Item";
import { startGetBrands } from "../actions/Brand";

const mapStateToProps = (state) => ({
  items: state.Item.items,
  brands: state.Brand.brands,
  error: state.Item.error
})

const mapDispatchToProps = dispatch => ({
  getItems: () => dispatch(startGetItems()),
  getBrands: () => dispatch(startGetBrands()),
  postItem: (request) => dispatch(startPostItem(request)),
})

export default connect(mapStateToProps, mapDispatchToProps)(Closet);
