package org.opennms.netmgt.dao.api;

import java.util.List;
import java.util.Map;
import org.opennms.netmgt.model.OnmsAlarm; // Assuming this would be the correct import
import org.opennms.netmgt.model.HeatMapElement;
import org.opennms.netmgt.model.alarm.AlarmSummary;
import org.opennms.netmgt.model.alarm.SituationSummary;

// Define a basic OnmsAlarm if it's not found, for compilation purposes of the interface
// In a real scenario, this would be a proper entity.
// interface OnmsAlarm {}

/**
 * Interface for data access operations related to Alarms.
 */
public interface AlarmDao extends Dao<OnmsAlarm, Integer> {

    /**
     * Finds an alarm by its reduction key.
     *
     * @param reductionKey the reduction key.
     * @return the alarm, or null if not found.
     */
    OnmsAlarm findByReductionKey(String reductionKey);

    /**
     * Gets summaries for alarms on specific nodes, including acknowledged ones.
     * @param nodeIds List of node IDs.
     * @return List of alarm summaries.
     */
    List<AlarmSummary> getNodeAlarmSummariesIncludeAcknowledgedOnes(List<Integer> nodeIds);

    /**
     * Gets summaries for active alarms on all nodes.
     * @return List of alarm summaries.
     */
    List<AlarmSummary> getNodeAlarmSummaries();

    /**
     * Gets summaries for situations.
     * @return List of situation summaries.
     */
    List<SituationSummary> getSituationSummaries();

    /**
     * Retrieves heatmap elements for a given entity.
     * @param entityNameColumn the column name for the entity's name.
     * @param entityIdColumn the column name for the entity's ID.
     * @param processAcknowledgedAlarms whether to include acknowledged alarms.
     * @param restrictionColumn column to apply restriction on.
     * @param restrictionValue value for the restriction.
     * @param groupByColumns columns to group by.
     * @return List of heatmap elements.
     */
    List<HeatMapElement> getHeatMapItemsForEntity(String entityNameColumn, String entityIdColumn, boolean processAcknowledgedAlarms, String restrictionColumn, String restrictionValue, String... groupByColumns);

    /**
     * Gets the total number of situations.
     * @return the count of situations.
     */
    long getNumSituations();

    /**
     * Gets the number of alarms in the last N hours.
     * @param hours Number of hours to look back.
     * @return the count of recent alarms.
     */
    long getNumAlarmsLastHours(int hours);

    /**
     * Retrieves alarms based on event parameters.
     * @param eventParameters A map of event parameter names and values.
     * @return A list of matching OnmsAlarm objects.
     */
    List<OnmsAlarm> getAlarmsForEventParameters(final Map<String, String> eventParameters);

    /**
     * Creates a situation and associates it with an alarm.
     *
     * @param alarmId The ID of the alarm to associate the situation with.
     * @param situationDetails Details of the situation.
     * @throws AlarmNotFoundException if the alarm with the given ID is not found.
     * @throws PersistenceException if there is an error persisting the situation.
     */
    void createSituationForAlarm(String alarmId, String situationDetails); // Throws clause is indicative
}

// Basic Dao interface placeholder if not found, for compilation of AlarmDao
interface Dao<T, ID> {
    // Basic DAO methods, assuming findOne, save, etc.
    // This would typically be more fleshed out or come from a library.
}

// Placeholder exceptions if not found
// class AlarmNotFoundException extends RuntimeException {
//     public AlarmNotFoundException(String message) { super(message); }
// }
// class PersistenceException extends RuntimeException {
//     public PersistenceException(String message, Throwable cause) { super(message, cause); }
// }
