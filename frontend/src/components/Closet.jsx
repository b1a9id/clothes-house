import React from 'react';
import { withStyles } from "@material-ui/core/styles";
import {
  CardActionArea,
  Typography,
  Grid,
  CardMedia,
  CardContent,
  Button,
  Fab,
  CardActions,
  Card
} from "@material-ui/core";
import AddIcon from "@material-ui/icons/Add";
import PropTypes from 'prop-types';
import AddDialog from "./common/AddDialog";
import { startRequest as itemsStartRequest } from '../actions/Item';
import { startRequest as brandsStartRequest } from "../actions/Brand";

const styles = theme => ({
  root: {
    display: 'flex',
  },
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
  media: {
    height: 140,
  },
  addButton: {
    margin: 0,
    top: 'auto',
    right: 20,
    bottom: 20,
    left: 'auto',
    position: 'fixed'
  }
});

class Closet extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      items: [],
      brands: [],
      openedModal: false,
    };
    props.dispatch(itemsStartRequest());
    props.dispatch(brandsStartRequest());
    this.handleOpenAddDialog = this.handleOpenAddDialog.bind(this);
    this.handleCloseAddDialog = this.handleCloseAddDialog.bind(this);
  }

  static getDerivedStateFromProps(nextProps, prevState) {
    if (prevState.items !== nextProps.items) {
      return {
        items: nextProps.items,
      }
    }
    if (prevState.brands !== nextProps.brands) {
      return {
        brands: nextProps.brands,
      }
    }
    return null;
  }

  handleOpenAddDialog() {
    this.setState( { openedModal : true });
  }

  handleCloseAddDialog() {
    this.setState( { openedModal : false });
  }

  render() {
    const { classes } = this.props;
    const { items, openedModal, brands } = this.state;

    return (
      <main className={classes.content}>
        <div className={classes.toolbar} />
        <Grid container spacing={3}>
          {items.map(item => (
            <Grid item xs={6} sm={3}>
              <Card className={classes.root}>
                <CardActionArea>
                  <CardMedia
                    className={classes.media}
                    image={item.imageUrl}
                    title="ETHOSENS1"
                  />
                  <CardContent>
                    <Typography gutterBottom variant="h5" component="h2">
                      {item.brand.name}
                    </Typography>
                    <Typography variant="body2" color="textSecondary" component="p">
                      {item.genre.name}
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" color="primary">
                      Learn More
                    </Button>
                  </CardActions>
                </CardActionArea>
              </Card>
            </Grid>
          ))}
        </Grid>
        <Grid container justify="flex-end" spacing={3}>
          <Fab color="primary" aria-label="add" className={classes.addButton} onClick={this.handleOpenAddDialog}><AddIcon /></Fab>
        </Grid>
        <AddDialog open={openedModal} handleCloseAddDialog={this.handleCloseAddDialog} brands={brands} />
      </main>
    );
  }
}

Closet.propTypes = {
  classes: PropTypes.object.isRequired,

  items: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      imageUrl: PropTypes.string.isRequired,
      brand: PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
      }),
      color: PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.number.isRequired
      }),
      genre: PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
        categoryName: PropTypes.string.isRequired
      })
    })
  ),
  error: PropTypes.bool.isRequired
}

export default withStyles(styles)(Closet);
