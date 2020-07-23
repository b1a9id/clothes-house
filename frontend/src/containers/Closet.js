import { connect } from 'react-redux';
import Closet from "../components/Closet";

const mapStateToProps = (state) => ({
  items: state.Closet.items,
  error: state.Closet.error
})

export default connect(mapStateToProps)(Closet);
