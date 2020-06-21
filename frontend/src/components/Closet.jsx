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

const useStyles = makeStyles((theme) => ({
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

export default class Closet extends React.Component {

  render() {
    const classes = useStyles();

    return (
      <main className={classes.content}>
        <div className={classes.toolbar} />
        <Grid container spacing={3}>
          <Grid item xs={6} sm={3}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  image="https://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-207a.jpg"
                  title="ETHOSENS1"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    ETHOSENS
                  </Typography>
                  <Typography variant="body2" color="textSecondary" component="p">
                    Shirts
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
          <Grid item xs={6} sm={3}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  image="https://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-706a.jpg"
                  title="ETHOSENS2"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    ETHOSENS
                  </Typography>
                  <Typography variant="body2" color="textSecondary" component="p">
                    Pants
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
          <Grid item xs={6} sm={3}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  image="https://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-207a.jpg"
                  title="ETHOSENS1"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    ETHOSENS
                  </Typography>
                  <Typography variant="body2" color="textSecondary" component="p">
                    Shirts
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
          <Grid item xs={6} sm={3}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  image="https://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-706a.jpg"
                  title="ETHOSENS2"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    ETHOSENS
                  </Typography>
                  <Typography variant="body2" color="textSecondary" component="p">
                    Pants
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
        </Grid>
      </main>
    );
  }
}
