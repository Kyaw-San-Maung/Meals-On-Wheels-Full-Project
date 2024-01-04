import "./home.css";
import {
  GetMealIcon,
  DonateIcon,
  HomeBanner1,
  HomeBanner2,
} from "../ImagesImport";
import About from "../about/About";
import MealService from "./meal-service/MealService";
import Testimonial from "./testimonial/Testimonial";
import { NavLink } from "react-router-dom";

const Home = () => {
  return (
    <>
      <div className="home-con container">
        <section className="home flex">
          <div className="left intro">
            <div className="text">
              <h1>
                Delivering <span>Nourishment</span>, Bringing
                <span>smiles</span>
              </h1>
              <p>
                Welcome to Meals On Wheels, where compassion meets cuisine. We
                are a dedicated team committed to delivering hot, nutritious
                meals to qualified adults in need. Our mission is simple —
                ensuring that no one goes hungry. Whether it's due to age,
                illness, or disability, we're here to provide a helping hand.
              </p>
            </div>
            <div className="btn-con flex">
              <NavLink to="/register" className="flex btn primary ">
                Get Meal <img src={GetMealIcon} alt="get meal icon" />
              </NavLink>
              <NavLink to="/donate" className="flex btn secondary ">
                Donate <img src={DonateIcon} alt="donate icon" />
              </NavLink>
            </div>
          </div>
          <div className="right">
            <img className="first-img" src={HomeBanner1} alt="Home Image" />
            <img
              className="second-img"
              src={HomeBanner2}
              alt="Home Image Woman"
            />
          </div>
        </section>
        <div className="status">
          <div>
            <h3>$20M+</h3>
            <p>Money Donated</p>
          </div>
          <div>
            <h3>👨‍🦳4583+</h3>
            <p>Donation Received</p>
          </div>
          <div>
            <h3>😇1032+</h3>
            <p>Successful Campaign</p>
          </div>
          <div>
            <h3>❣38146+</h3>
            <p>Volunteers</p>
          </div>
        </div>
      </div>
      <About />
      <MealService />
      <Testimonial />
    </>
  );
};

export default Home;
