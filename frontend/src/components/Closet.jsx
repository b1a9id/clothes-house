import React from 'react';
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import CardActions from "@material-ui/core/CardActions";
import CardActionArea from "@material-ui/core/CardActionArea";
import PropTypes from 'prop-types';

export default class Closet extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      items: props.onMount()
    };
  }

  render() {
    // TODO
    const classes = makeStyles((theme) => ({
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
    }));

    const { items } = this.props;

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
      </main>
    );
  }
}

Closet.propTypes = {
  onMount: PropTypes.func.isRequired,

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
