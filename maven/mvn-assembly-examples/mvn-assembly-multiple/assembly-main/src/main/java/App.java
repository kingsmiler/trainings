import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.PersonRepository;

/**
 * Created with IntelliJ IDEA.
 * User: adilfulara
 * Date: 2/1/14
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] arguments) {
        PersonRepository repository = new InMemoryRepository();
        System.out.println(repository.getAllPersons());

        logger.info("Started incredibly useless and unhelpful example application!");
        logger.debug("Press Ctrl+C to exit.");

        try {
            while (true) {
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            logger.info("Shutting down incredibly useless and unhelpful example application.");
        }
    }
}
