import React from 'react';
import PropTypes from 'prop-types';
import AppBar from '@material-ui/core/AppBar';
import Divider from "@material-ui/core/Divider";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import { ListItemIcon, Hidden } from "@material-ui/core";
import ListItemText from "@material-ui/core/ListItemText";
import FavoriteRoundedIcon from '@material-ui/icons/FavoriteRounded';
import SettingsRoundedIcon from '@material-ui/icons/SettingsRounded';
import MenuIcon from '@material-ui/icons/Menu';
import { makeStyles, useTheme } from "@material-ui/core/styles";
import CssBaseline from "@material-ui/core/CssBaseline";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import Drawer from "@material-ui/core/Drawer";

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
	root: {
		display: 'flex',
	},
	drawer: {
		[theme.breakpoints.up('sm')]: {
			width: drawerWidth,
			flexShrink: 0,
		},
	},
	appBar: {
		[theme.breakpoints.up('sm')]: {
			width: `calc(100% - ${drawerWidth}px)`,
			marginLeft: drawerWidth,
		},
	},
	menuButton: {
		marginRight: theme.spacing(2),
		[theme.breakpoints.up('sm')]: {
			display: 'none',
		},
	},
	toolbar: theme.mixins.toolbar,
	drawerPaper: {
		width: drawerWidth,
	},
	content: {
		flexGrow: 1,
		padding: theme.spacing(3),
	},
}));

function ResponsiveDrawer(props) {
	const { container } = props;
	const classes = useStyles();
	const theme = useTheme();
	const [mobileOpen, setMobileOpen] = React.useState(false);

	const handleDrawerToggle =() => {
		setMobileOpen(!mobileOpen);
	}

	const drawer = (
		<div>
			<div className={classes.toolbar} />
			<Divider />
			<List>
				<ListItem button key="Closet">
					<ListItemIcon>{ <FavoriteRoundedIcon /> }</ListItemIcon>
					<ListItemText primary="Closet" />
				</ListItem>
				<ListItem button key="Settings">
					<ListItemIcon>{ <SettingsRoundedIcon /> }</ListItemIcon>
					<ListItemText primary="Settings" />
				</ListItem>
			</List>
		</div>
	);

	return (
		<div className={classes.root}>
			<CssBaseline />
			<AppBar position="fixed" className={classes.appBar}>
				<Toolbar>
					<IconButton
						color="inherit"
						aria-label="open drawer"
						edge="start"
						onClick={handleDrawerToggle}
						className={classes.menuButton}
					>
						<MenuIcon />
					</IconButton>
					<Typography variant="h6" noWrap>
						Menu
					</Typography>
				</Toolbar>
			</AppBar>
			<nav className={classes.drawer} aria-label="closet">
				<Hidden smUp implementation="css">
					<Drawer
						container={container}
						variant="temporary"
						anchor={theme.direction === 'rtl' ? 'right' : 'left'}
						open={mobileOpen}
						onClose={handleDrawerToggle}
						classes={{
							paper: classes.drawerPaper,
						}}
						ModelProps={{
							keepMounted: true,
						}}
					>
						{drawer}
					</Drawer>
				</Hidden>
				<Hidden xsDown implementation="css">
					<Drawer
						classes={{
							paper: classes.drawerPaper,
						}}
						variant="permanent"
						open
					>
						{drawer}
					</Drawer>
				</Hidden>
				<main className={classes.content}>
					<div className={classes.toolbar} />
					<Typography paragraph>
						TEST1
					</Typography>
					<Typography paragraph>
						TEST2
					</Typography>
				</main>
			</nav>
		</div>
	);
}

ResponsiveDrawer.propTypes = {
	container: PropTypes.any,
};

export default ResponsiveDrawer;
