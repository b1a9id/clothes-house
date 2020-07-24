import { connect } from 'react-redux';
import Closet from "../components/Closet";

const mapStateToProps = (state) => ({
  items: state.Item.items,
  brands: state.Brand.brands,
  error: state.Item.error
})

export default connect(mapStateToProps)(Closet);
